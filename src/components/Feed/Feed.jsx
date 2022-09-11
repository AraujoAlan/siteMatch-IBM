import React from 'react'
import '../../css/styles.css'
import seta from '../../img/seta.png'

export default function Feed() {

  return (
    
    <>
      <div class="topo"></div>
    <div class="topoContent">
        <div class="flexRow justifyContentCenter alignContentCenter flex logo">
            <h1>Enjoy &</h1>
            <h1 class="logoBlack">Job</h1>
        </div>

        <div class="flexRow justifyContentCenter alignContentCenter flex">
            <h2><u>Notícias</u></h2>
        </div>

        <div class="flex back">
            <button class="btnBgLaranja" onclick="location.href='/principal.html'"><img class="seta" alt="seta" src={seta} /></button>
        </div>
    </div>
    <div class="subTopo"></div>

    <p class="paragrafo">Aqui você encontra o direcionamento adequado para sites de referência em informações e comunidades, diversas vertentes essenciais para os profissionais de todas as áreas e criação de conexões e comunicação entre pessoas. Além de anúncios de vagas que condizem com seu perfil e claro, um match perfeito com a Empresa que procura alguém como você!</p>

    <p class="paragrafo1">Fique por dentro das notícias e tire suas dúvidas nos sites que selecionamos para você!</p>

    <div>
    <div class="links">
        <ul>
            <li><a href="https://pt.stackoverflow.com/">Stack Overflow</a></li>
            <li><a href="https://github.com/">Git Hub</a></li>
            <li><a href="https://www.w3schools.com/">W3School</a></li>
            <li><a href="https://developer.mozilla.org/pt-BR/">MDN Web Docs</a></li>
        </ul>
    </div>
    </div> 

    <div>
        <div>
            <h3 class="letreiro"><u>Confira as vagas que fazem um match com seu perfil!</u></h3>

          <div id="box">
            <div id="infoBox"></div>
            <div class="paragrafo2"></div>
            <h4>PLENO FRONT-END COM REACT - BERNA</h4>
          </div>

          <div class="paragrafo3">
            <p>- <b>9 vagas </b>disponíveis<br/></p>
                <p>- São Paulo, São Paulo, Brasil (remoto)<br/>
                - Integral (Jornada de 8h)
            </p>
          </div>
          <div class="paragrafo4">  
            <h4><b>REQUISITOS!</b></h4>
          </div>  
          <p>- Formado em Análise e Desenvolvimento de Sistemas ou currículo e indicações;</p><br/>
          <p>- Fala avançada em inglês e intermediária em alemão;</p><br/>
          <p>- Conhecimento avançado em react.js e react-native.</p><br/>
           <p><b>Te interessa?</b></p><br/>
            <button> 
              <b> Candidate-se </b>
            </button>
    </div> 
</div>

  <div id="box1">
      <div id="infoBox1">
        <div class="paragrafo5">
            <h4>SÊNIOR FULLSTACKER - BMW</h4>
        </div>

        <div class="paragrafo6">
            <p>- <b>4 vagas </b>disponíveis<br/></p>
                <p>- Rio de Janeiro, Rio de Janeiro, Brasil (híbrido)<br/>
                - Integral (Jornada de 8h)
            </p>
            <div class="paragrafo7">  
              <h4><b>REQUISITOS</b></h4>
            </div>  
          <p>- Formado em Análise e Desenvolvimento de Sistemas ou Ciência da Computação e currículo com indicações profissionais.<br/></p>
          <p>- Fala nativa em inglês;<br/></p>
          <p>- Conhecimento em programação com node.js, nest.js, typescript, kubbernets, graphQL, grafana, react.js e react-native.<br/><br/></p>
           <p><b>Te interessa?</b></p><br/>
            <button>
                <b>Candidate-se</b>
            </button>
        </div>
      </div>
    </div>

     <div class="final">
        <p>Realize projetos, responda nossoas atividades disponíveis, interaja com a página e treine todos os dias suas habilidades aqui! Lembre-se, quanto mais soubermos de você, mais fácil de encontrar seu match perfeito!</p>
    </div>


    <div class="voltar">
         <p>Clique <a href="principal.html">aqui</a> para voltar a página inicial.</p>
    </div>
    </>

  )
}
