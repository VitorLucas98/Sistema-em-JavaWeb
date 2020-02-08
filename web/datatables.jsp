 <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="datatables/dataTables.bootstrap4.min.js"></script>
     <script type="text/javascript">
    $(document).ready(function() {
    $('#tabelaPesquisar').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros por p�gina",
            "zeroRecords": "Nenhum dado foi encontrado - Desculpe",
            "info": "Mostrando p�gina _PAGE_ de _PAGES_",
            "infoEmpty": "N�o foram encontrados resultados.",
            "infoFiltered": "(Filtrado de _MAX_ registros totais.)",
        "search":         "Pesquisar:",
            "paginate": {
        "first":      "Primeiro",
        "last":       "�ltimo",
        "next":       "Pr�ximo",
        "previous":   "Anterior"
    }
            }
        
        
    }
            )
    ;
} );
    </script>   
