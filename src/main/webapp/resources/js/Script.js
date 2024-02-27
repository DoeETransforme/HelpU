// function toggleMenu() {
//     let menuLateral = document.getElementById("menu-lateral");
//     menuLateral.classList.toggle("mostrar");
// }

// window.onclick = function(event) {
//     let menuLateral = document.getElementById("menu-lateral");
//     if (!event.target.matches('.hamburguer-menu') && !event.target.closest('.menu-lateral')) {
//         menuLateral.classList.remove("mostrar");
//     }
// }


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
    

