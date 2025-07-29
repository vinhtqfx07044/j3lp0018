window.onload = function() {
    // Find the success message element that Thymeleaf renders.
    const successAlert = document.querySelector('.alert-success');

    // Check if the success message element exists in the DOM.
    // The th:if in the HTML file ensures this element only exists after a successful redirect.
    if (successAlert) {
        
        const form = document.querySelector('form');
        if (form) {
            // Disable all form fields (inputs, textarea, button)
            const elements = form.elements;
            for (let i = 0; i < elements.length; i++) {
                elements[i].disabled = true;
                // Optionally add a class for styling disabled elements
                elements[i].classList.add('disable'); 
            }
            
            // Change the button text to give clear feedback
            const button = form.querySelector('.send-button');
            if(button) {
                button.innerHTML = "✓ Sent";
            }
        }
    }
};
