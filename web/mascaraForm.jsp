<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
    <script src="js/jquery.mask.min.js"></script> 
    <script>
var CpfCnpjMaskBehavior = function (val) {
			return val.replace(/\D/g, '').length <= 11 ? '000.000.000-009' : '00.000.000/0000-00';
		},
    cpfCnpjpOptions = {
    	onKeyPress: function(val, e, field, options) {
      	field.mask(CpfCnpjMaskBehavior.apply({}, arguments), options);
      }
    };
        
        $('.telefone').mask('(00) 0 0000-0000');
        $('.telefoneReferencia').mask('(00) 0 0000-0000');
$('.valor').mask('#.##0,00', {reverse: true});
$('.estado').mask('AA');
$(function() {
	$(':input[name=cpf]').mask(CpfCnpjMaskBehavior, cpfCnpjpOptions);
})
$(function() {
	$(':input[name=cpf_cnpj]').mask(CpfCnpjMaskBehavior, cpfCnpjpOptions);
})

        </script>
    
    
    <%--<script type="text/javascript"> 
jQuery.noConflict();
jQuery(function($){
   $("#data").mask("99/99/9999");
   $("#telefone").mask("(099) 99999-9999");
   $("#cpf_cnpj").mask("999.999.999-99");
   $("#cpf").mask("999.999.999-99");
   $("#telefoneReferencia").mask("(099) 99999-9999");
    
});
  
</script> --%>