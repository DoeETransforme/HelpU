function toggleMenu() {
    let menuLateral = document.getElementById("menu-lateral");
    menuLateral.classList.toggle("mostrar");
}

window.onclick = function(event) {
    let menuLateral = document.getElementById("menu-lateral");
    if (!event.target.matches('.hamburguer-menu') && !event.target.closest('.menu-lateral')) {
        menuLateral.classList.remove("mostrar");
    }
}

function toggleMenuFiltro() {
    let filtro = document.getElementById("filtro-container");
    filtro.classList.toggle("mostrar");
}

// Adicione um ouvinte de eventos para o clique na imagem SVG
document.getElementById("imagem-filtro").addEventListener("click", toggleMenuFiltro);

// Adicione um ouvinte de eventos para fechar o menu se clicar fora dele
window.onclickFiltro = function(event) {
    let filtro = document.getElementById("filtro-container");
    if (!event.target.matches('#imagem-filtro') && !event.target.closest('.filtro-container')) {
        filtro.classList.remove("mostrar");
    }
};


    

