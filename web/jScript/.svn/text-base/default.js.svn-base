/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var migalhaPao = '';
function urlSite(){
    var url = window.location;
    var dados = "";
    url = url.toString()
    url = url.split(".");
    migalhaPao = url[0].split( "/" );
    migalhaPao = migalhaPao[migalhaPao.length - 1];
    switch (migalhaPao) {
        case 'usuario':
            dados = "<p> Cadastros > Usuário</p>";
            break;
        case 'menu':
            dados = "<p> Cadastros > Menu </p>";
            break;
        case 'fornecedor':
            dados = "<p> Cadastros > Fornecedor </p>";
            break;
        default:
            dados = "<p>Página principal</p>";
            break;
    }
    document.getElementById('migalhaPao').innerHTML = '';
    document.getElementById('migalhaPao').innerHTML = '<li>' + dados + '</li>';
}
