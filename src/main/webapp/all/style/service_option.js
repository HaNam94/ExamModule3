
function getOption() {
    let option = document.getElementById("option").value;
    // alert("option value: " + option);
    if (option === "Import") {
        document.getElementById("f-row").style.display = "table-row";
        document.getElementById("g-row").style.display = "table-row";
        document.getElementById("h-row").style.display = "table-row";

        document.getElementById("i-row").style.display = "none";
        document.getElementById("j-row").style.display = "none";
    } else if (option === "Export") {
        document.getElementById("f-row").style.display = "none";
        document.getElementById("g-row").style.display = "none";
        document.getElementById("h-row").style.display = "none";

        document.getElementById("i-row").style.display = "table-row";
        document.getElementById("j-row").style.display = "table-row";
    }
}