function toggleMenuFiltro(){
    let menuFiltro = document.getElementById("filtro-container");
    menuFiltro.classList.toggle("mostrar1");
}
window.onclick = function(event){
    let menuLateral = document.getElementById("fittro-container");
    if(!event.target.matches('menu-topo-filtro')&& !event.target.closest('.filtro-container')){
        menuFiltro.classList.remove("mostrar1")
    }
}
    