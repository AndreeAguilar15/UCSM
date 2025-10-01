//Validación simple y feedback al enviar el formulario
document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('leadForm');
  form.addEventListener('submit', (e) => {
    e.preventDefault();
    // aquí podrías enviar por fetch a backend o a un servicio (Formspree, etc)
    const name = form.name.value;
    const email = form.email.value;
    // Simular envío
    alert(`Gracias ${name}! Nos contactaremos a ${email}.`);
    form.reset();
  });
});
