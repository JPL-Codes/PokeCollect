

$(document).ready(function () {
    'use strict';
    getPokemonNamesAutocomplete();

});

function  getPokemonNamesAutocomplete() {
    $(function () {
        $('#searchBox').autocomplete({
            source: "getPokemonNamesAutocomplete",
            minLength: 3
        });
    });
}