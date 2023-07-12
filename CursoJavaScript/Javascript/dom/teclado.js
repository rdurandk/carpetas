const d = document;
let x = 0;
let y = 0;
export function moveBall(e, ball, stage) {
  const $ball = d.querySelector(ball),
    $stage = d.querySelector(stage);
  //Medida de pelota y el escenario
  const limitBall = $ball.getBoundingClientRect();
  const limitStage = $stage.getBoundingClientRect();
  //console.log(limitBall)
  //console.log(limitStage)
  let x = 0;
  let y = 0;
  switch (e.keyCode) {
    case 37:
      if (limitBall.left > limitStage.left) {
        x--;
      }
      break;
    case 38:
      e.preventDefault();
      if (limitBall.top > limitStage.top) {
        y--;
      }
      break;
    case 39:
      if (limitBall.right < limitStage.right) {
        x++;
      }
      break;
    case 40:
      e.preventDefault();
      if (limitBall.bottom < limitStage.bottom) {
        y++;
      }
      break;
    default:
      break;
  }
  $ball.style.transform += `translate(${x * 10}px, ${y * 10}px)`;
}

export function shortcuts(e) {
  /*
     console.log(e.type);
     console.log(e.key);
     console.log(e.keyCode);
     console.log(`ctrl: ${e.ctrlKey}`);
     console.log(`alt: ${e.altKey}`);
     console.log(`shift: ${e.shiftKey}`);
     console.log(e);
     */
  if (e.key === "a" && e.altKey) {
    alert("Haz lanzado una alerta");
  }
  if (e.key === "c" && e.altKey) {
    confirm("Haz lanzado una confirmacion");
  }
  if (e.key === "p" && e.altKey) {
    prompt("Haz lanzado un Aviso");
  }
}
