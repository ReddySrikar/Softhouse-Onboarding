/**
 * Created by Srikar on 20-09-2016.
 */

/**
 * The noteService factory has the sole responsibility to communicate between the frontend application
 * and the backend application. You can think of it as a 'internal API' for our frontend application.
 *
 * @param $http the injected http service
 * @param $interpolate the injected interpolate service
 * @returns {Object}
 */

function userService($http, $interpolate){

    /**
    * This is the base URL to our API in the backend.
    * @type {String}
    */
    var toListURL   = '/api/users/';

    /**
    * This is the detail URL to our API in the backend. It handles requests with path parameters.
    * E.g. /api/note/5/
    * @type {Function}
    */
    var toDetailURL = $interpolate('/api/users/{{id}}/');

    /**
    * Sends a GET request to the API.
    * @returns {Object}
    */
    function list() {
    return $http.get(toListURL);
    }


    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };


    /**
    * Sends a POST request to the API
    * @param {String} username the username of the user to create
    * @param {String} emailid the email of the user to create
    * @param {String} password the password of the user to create
    * @param {String} confirm_password the confirm_password of the user to create
    * @returns {Object}
    */
    function create(username, emailid, password, confirm_password) {
    return $http.post(toListURL, {username:username, emailid:emailid, password:password, confirm_password:confirm_password});
    }

    /**
     * Sends a DELETE request to the API
     * @param {Number} id the id number of the user to delete
     * @returns {Object}
     */
    function destroy(id) {
        return $http.delete(toDetailURL({ id: id }));
    }

    function update(id ,username, emailid, password, confirm_password) {
        return $http.put(toDetailURL({ id: id }), { id: id, username:username, emailid:emailid, password:password, confirm_password:confirm_password });
    }

}