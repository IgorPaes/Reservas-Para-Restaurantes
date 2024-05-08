function userOnline(){

  if (document.cookie.includes('isValid=false')){
      console.log('Cliente nao esta logado');

  }else {
      console.log('O Cliente esta logado');
     // window.location.href='/pages/reservas/reservas.html';
  }
}