/**
 * Created by Srikar on 01-09-2016.
 */
/**
 * @param {Object} noteService the noteService which handles the communication between the controller and the API.
 * @constructor
 */
function OrderFormController(orderService) {
    var vm = this;

    vm.$onInit = $onInit;

    /**
     * If a parent controller has provided a on-submit attribute, then we use it. Otherwise, use defaultSubmitForm
     * @example <note-form on-submit="doSomething()"></note-form>
     * @type {Function}
     */
    vm.onSubmit = vm.onSubmit || defaultSubmitForm;

    /**
     * If a parent controller has provided a on-reset attribute, then we use it. Otherwise, use defaultResetForm
     * @example <note-form on-reset="doSomething()"></note-form>
     * @type {Function}
     */
    vm.onReset  = vm.onReset || defaultResetForm;


    /**
     * Initializer. Called every time this component is created (using <note-form></note-form>).
     */
    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.empid = parentControllerHasSetData ? vm.data.empid : '';
        vm.empname = parentControllerHasSetData ? vm.data.empname : '';
        vm.phmod = parentControllerHasSetData ? vm.data.phmod : '';
        vm.lapmod  = parentControllerHasSetData ? vm.data.lapmod  : '';
    }


    /**
     * The default function for when the user presses 'Submit'. The default behaviour
     * for a form is to create a new note using the API.
     * @param {String} title
     * @param {String} text
     */
    function defaultSubmitForm(empid, empname, phmod, lapmod) {
        orderService.create(empid, empname, phmod, lapmod)
            .then(vm.ordersController.refreshOrders)
            .then(defaultResetForm);
    }


    /**
     * The default behaviour resets the note to its starting state. Meaning, we clear all the fields from data.
     */
    function defaultResetForm() {
        vm.title = '';
        vm.text = '';
        vm.noteForm.$setPristine();
        vm.noteForm.$setUntouched();
    }
}