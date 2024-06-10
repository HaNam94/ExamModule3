<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../all/js/bootstrap.min.js"></script>
<script src="../all/jquery/jquery-3.5.1.min.js"></script>
<script src="../all/datatables/js/jquery.dataTables.min.js"></script>
<script src="../all/datatables/js/dataTables.bootstrap4.min.js"></script>

<%--Pagination--%>
<script>
    $(document).ready(function() {
        $('#pagination').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

<%--CLEAR ON SCREEN--%>
<script>
    function displayHiddenElement(id) {
        let thisItem = document.getElementById(id);
        thisItem.style.display = "none";
    }
</script>
