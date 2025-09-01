// Use DOMContentLoaded for better performance (doesn't wait for images)
document.addEventListener('DOMContentLoaded', function () {
    const successAlert = document.querySelector('.alert-success');
    const form = document.querySelector('form');

    // Logic 1: Disable form completely IF message was sent successfully
    if (successAlert && form) {
        const elements = form.elements;
        for (let i = 0; i < elements.length; i++) {
            elements[i].disabled = true;
            elements[i].classList.add('disable');
        }
        const button = form.querySelector('.btn');
        if (button) {
            button.innerHTML = "✓ Sent";
        }
    }

    // Logic 2: Prevent duplicate submissions WHEN user clicks send button
    if (form && !successAlert) { // Only add listener if form hasn't been sent yet
        form.addEventListener('submit', function () {
            const button = form.querySelector('.btn');
            if (button) {
                button.disabled = true;
                button.textContent = 'Sending...'; // Use textContent for security
            }
        });
    }
});
