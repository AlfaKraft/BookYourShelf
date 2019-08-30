function filtered() {
    var table, tr, td, i, txtValue;
    table = document.getElementById("historytable");
    tr = table.getElementsByTagName("tr");
    console.log(document.getElementById("filterBorrowed").checked)
    if (document.getElementById("filterBorrowed").checked){
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            if (td) {
                txtValue = td.textContent || td.innerText;
                console.log(txtValue);
                if (txtValue === ""){
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    } else {
        for (i = 0; i < tr.length; i++) {
            tr[i].style.display = "";
        }
    }


}