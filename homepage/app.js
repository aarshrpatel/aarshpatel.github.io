const sections = document.querySelectorAll('.section');
const sectBtns = document.querySelectorAll('.controls');
const sectBtn = document.querySelectorAll('.control');
const allSections = document.querySelectorAll('.main-content');

function PageTransitions() {
    // Button click active class
    for (let i = 0; i < sectBtn.length; i++) {
        sectBtn[i].addEventListener('click', function () {
            let currentBtn = document.querySelectorAll('.active-btn');
            currentBtn[0].className = currentBtn[0].className.replace('active-btn', '');
            this.className += ' active-btn';
        });
    }

    // Sections Active class
    allSections.forEach((section) => {
        section.addEventListener('click', (e) => {
            const id = e.target.dataset.id;
            if (id) {
                // Toggle 'active' class on clicked button
                e.target.classList.toggle('active');

                // Toggle 'active' class on corresponding section
                const element = document.getElementById(id);
                if (element) {
                    element.classList.toggle('active');
                }

                // Remove 'active' class from other buttons
                sectBtns.forEach((btn) => {
                    if (btn !== e.target) {
                        btn.classList.remove('active');
                    }
                });

                // Remove 'active' class from other sections
                sections.forEach((otherSection) => {
                    if (otherSection.id !== id) {
                        otherSection.classList.remove('active');
                    }
                });
            }
        });
    });
}

PageTransitions();
