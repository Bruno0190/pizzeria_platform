document.addEventListener('DOMContentLoaded', function() {
    // Prendi il percorso corrente
    const currentPath = window.location.pathname;

    const dropdownItems = ["/pizzas", "/appetizers", "/drinks"];

    for (let i = 0; i < dropdownItems.length; i++) {
        if (currentPath.includes(dropdownItems[i])) {
            // Nascondi la voce corrispondente alla pagina corrente
            document.querySelector(`[href="${dropdownItems[i]}"]`).closest('li').style.display = 'none';
        }
    }
});
    
   