import React from 'react'
import '../../css/styles.css'
import seta from '../../img/seta.png'

export default function Configuracoes() {

  return (
    
    <>
      <div>
      <div class="topo"></div>
        <div class="topoContent">
            <div class="flexRow justifyContentCenter alignContentCenter flex logo">
                <h1>Enjoy &</h1>
                <h1 class="logoBlack">Job</h1>
            </div>
    
            <div class="flexRow justifyContentCenter alignContentCenter flex">
                <h2><u>Configurações</u></h2>
            </div>
    
            <div class="flex back">
                <button class="btnBgLaranja" onclick="location.href='/principal.html'"><img class="seta" alt="seta" src={seta} /></button>
            </div>
        </div>
        <div class="subTopo"></div>

            <p class="paragrafo">Página referente ao melhoramento da experiência do usuário na plataforma, visando a adequação do site às preferências e necessidades do usuário, iniciando a implementação de um ambiente inclusivo e integrador.</p>

        </div>

        <fieldset class="fieldsetContent">
            <legend>Altere suas Configurações</legend>
                <div class="cardContent">
                    <label for="">Brilho</label>
                    <input type="range"/>
                </div>

                <div class="cardContent"> <br/>
                    <label for="">Claro</label>
                    <input type="radio"/>
                    <label for="">Escuro</label>
                    <input type="radio"/>
                </div>

                <div class="cardContent"> <br/>
                    <label for="">Alterar nome</label>
                    <input type="text" placeholder="Digite o novo nome"/>
                </div>

                
                <div class="cardContent"> <br/>
                    <label for="">Alterar email</label>
                    <input type="text" placeholder="Digite o novo e-mail"/>
                </div>

                <div class="cardContent"> <br/>
                    <label for="">Alterar senha</label>
                    <input type="text" placeholder="Digite uma nova senha"/>
                </div>
                <button type="button" class="btnSalvarAlteracoes">Salvar</button>
        </fieldset>
    </>

  )
}
