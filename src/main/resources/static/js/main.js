/*
Creates a datatable, fills it with response JSON, populates table with data, and responds to event clicks
@Mike Byrd - iByrd
*/

let table;

$(document).ready(function () {
    'use strict';
    table = $('#pokemon-table').DataTable();

    // event lister that shows additional row details
    showDetails();
});


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
                    <td>Image: </td>
                    <td><img src="${rowDetails.images.small}"</td>
                </tr>
                
            </table>`;
};