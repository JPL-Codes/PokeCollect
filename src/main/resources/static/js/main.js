/*
Creates a datatable, fills it with response JSON, populates table with data, and responds to event clicks
@Mike Byrd - iByrd
*/

let table;

$(document).ready(function () {
    'use strict';
    table = $('#pokemon-table').DataTable();

    getPokemonNamesAutocomplete();

    addPokeCardButton();

    showDetails();
});

function getPokemonNamesAutocomplete() {
    $(function () {
        $('#searchBox').autocomplete({
            source: "getPokemonNamesAutocomplete",
            minLength: 3
        });
    });
}


$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

/**
 * Adds a "Add to Collection" button to the Pokemon table rows and handles the click event.
 */
function addPokeCardButton() {
    $('#pokemon-table tbody').on('click', 'Button', function () {
        let row = $(this).closest('tr');

        console.log(table.row(row).data());

        let data = {
            id: table.row(row).data().id
        };

        data.name = table.row(row).data().name;
        data.level = table.row(row).data().level;
        data.hp = table.row(row).data().hp;
        data.types = table.row(row).data().types;

        console.log(data);

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        console.log('The token is ' + token)
        console.log('The header is ' + header)

        $.ajax({
            type : "POST",
            url : "/results",
            contentType: 'application/json',
            data: JSON.stringify(data),
            timeout : 100000,
 //           headers : {header : header, token : token},
            success : function(result) {
                alert(data.name + ' has been successfully added to your collection!');
                console.log("SUCCESS: ", data);

            },
            error : function(e) {
                console.log("ERROR: ", e);

            },
            done : function(e) {
                console.log("DONE");
            }
        });

    });
}


// Add event listener for opening and closing details
// CITATION - this method is from the DataTables website
// @ https://datatables.net/examples/api/row_details.html
function showDetails() {
    $('#pokemon-table tbody').on('click', 'td.dt-control', function () {
        let tr = $(this).closest('tr');
        let row = table.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            // Open this row
            row.child(formatRowDetails(row.data())).show();
            tr.addClass('shown');
        }
    });
}

// adds additional details when row is clicked
function formatRowDetails(rowDetails) {
    return `<table class="d-flex justify-content-center">
                <tr>
                    <td>ID: </td>
                    <td>${rowDetails.id}</td>
                </tr> 
                <tr>
                    <td>Distributed with Set: </td>
                    <td>${rowDetails.set.name}</td>
                </tr>
                <tr>
                    <td>Level: </td>
                    <td>${rowDetails.level}</td>
                </tr>
                <tr>
                    <td>HP: </td>
                    <td>${rowDetails.hp}</td>
                </tr>
                <tr>
                    <td>Types: </td>
                    <td>${rowDetails.types}</td>
                </tr>
                
            </table>`;
}