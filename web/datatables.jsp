 <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
     <script type="text/javascript" src="datatables/dataTables.bootstrap4.min.js"></script>
     <script type="text/javascript">
    $(document).ready(function() {
    $('#tabelaPesquisar').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros por página",
            "zeroRecords": "Nenhum dado foi encontrado - Desculpe",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "Não foram encontrados resultados.",
            "infoFiltered": "(Filtrado de _MAX_ registros totais.)",
        "search":         "Pesquisar:",
            "paginate": {
        "first":      "Primeiro",
        "last":       "Último",
        "next":       "Próximo",
        "previous":   "Anterior"
    }
            }
        
        
    }
            )
    ;
} );
    </script>   
