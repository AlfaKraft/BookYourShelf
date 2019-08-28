function myFunction() {

    var input, filter, table, tr, td, i, txtValue, title, txtTitle;
    input = document.getElementById("search-user");
    filter = input.value.toUpperCase();
    table = document.getElementById("borrowtable");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        title = tr[i].getElementsByTagName("td")[1];
        if (td || title) {
            txtTitle = title.textContent || name.innerText;
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1 || txtTitle.toUpperCase().indexOf(filter) > -1)
            {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}