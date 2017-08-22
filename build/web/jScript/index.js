/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function fadein(input, container) {
    container.fadeIn('slow');
}
function fadeout(input, container) {
    container.fadeOut('slow');
}
function validaLogin(xhr, status, args) {
    if(args.validationFailed) {
        dlg.show();
        return false
    }else if(!args.login){
        dlg.show();
        return false;
    }else if(args.login){
        acaoRedirect.show();
        return true;
    }
}
limpar = function(){
    document.getElementById('validarUsuario:usrSenha').value = "";
}

