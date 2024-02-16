function toggleMenu() {
    let menuLateral = document.getElementById("menu-lateral");
    menuLateral.classList.toggle("mostrar");
}

window.onclick = function(event) {
    let menuLateral = document.getElementById("menu-lateral");
    if (!event.target.matches('.hamburguer') && !event.target.closest('.menu-lateral')) {
        menuLateral.classList.remove("mostrar");
    }
}