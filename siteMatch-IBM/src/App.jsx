import React from 'react'
import { Routes, Route, Link} from 'react-router-dom'
import Home from './components/Home/Home'
import Chat from './components/Chat/Chat'
import Configuracoes from './components/Configuracoes/Configuracoes'
import Feed from './components/Feed/Feed'
import Match from './components/Match/Match'
import Skills from './components/Skills/Skills'
import Footer from './components/Footer/Footer'
import Container from './Layout/Container'
import Perfil from './components/Perfil/Perfil'

export default function App() {

  return (

    <>

          <header>
              <nav>
                  <ul>
                      <Link to="/">Home</Link>
                      <Link to="/Chat">Chat</Link>
                      <Link to="/Configuracoes">Configurações</Link>
                      <Link to="/Feed">Feed</Link>
                      <Link to="/Match">Match</Link>
                      <Link to="/Skills">Skills</Link>
                      <Link to="/Perfil">Perfil</Link>
                  </ul>
              </nav>
          </header>

          <Container>
          <Routes>

            <Route path='/' element={<Home/>}/>
            <Route path='/Chat' element={<Chat/>}/>
            <Route path='/Configuracoes' element={<Configuracoes/>}/>
            <Route path='/Feed' element={<Feed/>}/>
            <Route path='/Match' element={<Match/>}/>
            <Route path='/Skills' element={<Skills/>}/>
            <Route path='/Perfil' element={<Perfil/>}/>

          </Routes>
          </Container>

        <Footer>
          
        </Footer>
    </>
  )
}
