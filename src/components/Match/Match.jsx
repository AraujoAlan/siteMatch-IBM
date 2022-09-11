import React from 'react'
import '../../css/styles.css'
import seta from '../../img/seta.png'

export default function Match() {

  return (
    
    <>
       <div class="topo"></div>
    <div class="topoContent">
        <div class="flexRow justifyContentCenter alignContentCenter flex logo">
            <h1>Enjoy &</h1>
            <h1 class="logoBlack">Job</h1>
        </div>

        <div class="flexRow justifyContentCenter alignContentCenter flex">
            <h2><u>Propostas</u></h2>
        </div>

        <div class="flex back">
            <button class="btnBgLaranja" onclick="location.href='/principal.html'"><img class="seta" alt="seta" src={seta} /></button>
        </div>

    </div>
    <div class="subTopo"></div>

    <h1>Suas propostas de entrevista</h1>

    <p class="paragrafo">As suas propostas.</p>

        <div>
            <div>
                <form action="index.html" method="POST" onsubmit="true">
                    <fieldset>
                        <legend>Sua lista de propostas correspondidas</legend>
                        <div class="paragrafo3">
                            <h4>Empresa  _ _ _ _ _  quer uma entrevista</h4>
                            <label>Corresponder</label>
                            <input type="checkbox"/>
                            <label>Recusar</label>
                            <input type="checkbox"/>
                        </div>

                        <div class="paragrafoProposta">
                            <h4>Empresa  _ _ _ _ _  quer uma entrevista</h4>
                            <label>Corresponder</label>
                            <input type="checkbox"/>
                            <label>Recusar</label>
                            <input type="checkbox"/>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </>

  )
}
