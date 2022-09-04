import React from 'react'
import { Link } from 'react-router-dom'

export default function Menu() {

  return (

    <header>
        <nav>
            <ul>
                <Link to="/">Home</Link>
                <Link to="/Chat">Chat</Link>
                <Link to="/Configuracoes">Configurações</Link>
                <Link to="/Feed">Feed</Link>
                <Link to="/Match">Match</Link>
                <Link to="/Skills">Skills</Link>
            </ul>
        </nav>
    </header>

  )
}
