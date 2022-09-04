import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from '../Home/Home'
import Chat from '../Chat/Chat'
import Configuracoes from '../Configuracoes/Configuracoes'
import Feed from '../Feed/Feed'
import Match from '../Match/Match'
import Skills from '../Skills/Skills'

export default function Router() {

  return (
    <>
        <Routes>

            <Route path='/' element={<Home/>}/>
            <Route path='/Chat' element={<Chat/>}/>
            <Route path='/Configuracoes' element={<Configuracoes/>}/>
            <Route path='/Feed' element={<Feed/>}/>
            <Route path='/Match' element={<Match/>}/>
            <Route path='/Skills' element={<Skills/>}/>

        </Routes>
    </>
  )
}
