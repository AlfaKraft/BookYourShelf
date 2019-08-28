function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue, genre, txtGenre;
    input = document.getElementById("search-book");
    filter = input.value.toUpperCase();
    table = document.getElementById("booktable");
    tr = table.getElementsByTagName("tr");



    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        genre = tr[i].getElementsByTagName("td")[1];
        if (td || genre) {
            txtGenre = genre.textContent || genre.innerText;
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1 || txtGenre.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}