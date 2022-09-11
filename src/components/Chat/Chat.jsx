import React from 'react'
import '../../css/styles.css'

export default function Chat() {

  return (
    <>
        <div class="topoChat"></div>
          <div class="topoContent">
            <button class="btnBgLaranja" onclick="location.href='/principal.html'"><img class="seta" alt="seta" src="./img/seta.png" /></button>
            <div class="flexRow justifyContentCenter flex logo">
                <h1>Enjoy &</h1>
                <h1 class="logoBlack">Job</h1>
            </div>
          </div>
        
        <div>
            <div class="card cardMsg">
                <div class="cardContent">
                    <div>
                        <img class="profilePicture" alt="Foto de perfil." src="./img/p4.png" />
                    </div>  
                    <div class="cardContent">
                        <h6 class="msgCardNome">Nate Davison - Recrutador SAP</h6> 
                        <span class="txtCinzaClaro msgCardTempo">09:26</span>
                    </div> 
                </div>
                <span class="txtCinzaClaro cardContentMsg">Bom dia, estava olhando o seu perfil e vi que muitas das suas soft skills batem com... </span>
            </div>
            <div class="card cardMsg">
                <div class="cardContent">
                    <div>
                        <img class="profilePicture" alt="Foto de perfil." src="./img/p1.png" />
                    </div>  
                    <div class="cardContent">
                        <h6 class="msgCardNome">Jakc Silva Fragosso - PMO</h6> 
                        <span class="txtCinzaClaro msgCardTempo crrChat">11:32</span>
                    </div> 
                </div>
                <span class="txtCinzaClaro cardContentMsg">Olá, tudo bem? Gostaríamos de marcar uma entrevista presencial, você estaria interessado?
                </span>
            </div>
            <div class="card cardMsg">
                <div class="cardContent">
                    <div>
                        <img class="profilePicture" alt="Foto de perfil." src="./img/p2.png" />
                    </div>  
                    <div class="cardContent">
                        <h6 class="msgCardNome">Andrew Oliver - Recrutador SBT</h6> 
                        <span class="txtCinzaClaro msgCardTempo">14:00</span>
                    </div> 
                </div>
                <span class="txtCinzaClaro cardContentMsg">Muito prazer em te conhecer! Sou o Andrew. Pela plataforma vimos que você deu um macth...</span>
            </div>
            <div class="card cardMsg">
                <div class="cardContent">
                    <div>
                        <img class="profilePicture" alt="Foto de perfil." src="./img/p3.png" />
                    </div>  
                    <div class="cardContent ">
                        <h6 class="msgCardNome">Mathew Santos - Recrutador IBM</h6> 
                        <span class="txtCinzaClaro msgCardTempo ">17:00</span>
                    </div> 
                </div>
                <span class="txtCinzaClaro cardContentMsg">Boa tarde, percebi que se interessou pela nossa vaga e que já realizou a pré-entrevista pela plataforma...</span>
            </div>
        </div>
    </>
  )
}
