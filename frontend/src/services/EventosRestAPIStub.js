import axios from 'axios'

export default {
  eventos: [],

  cargarEventos () {
    return this.eventos.length > 0 ? Promise.resolve(this.eventos) : axios.get('https://script.googleusercontent.com/macros/echo?user_content_key=qlKv7zntgaC90D18UTbDJnFw5I1nM5CD2R95Kj3DEcURj1F9C8_8Q3IV6h_D6PctiJAuSLhPrt2xio341aSqLp1cuFZKswVRm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnC6fd_ybEumZVt2CMVJrGB-ugol7U6H3DnG4LpLwvBpsgl4wAeSr2M3ffly-D9Fy6Rih7LyEewHE&lib=MZocvt9WQkmIc2hvb1CgWfEV35yg9P-n_')
      .then(respuesta => {
        this.eventos = respuesta.data.data.map((evento, indice) => Object.assign(evento, {id: indice}))
        return this.eventos
      })
  },

  destacados () {
    return this.cargarEventos().then(eventos => eventos.filter(evento => evento.promoted))
  },

  noDestacados () {
    return this.cargarEventos().then(eventos => eventos.filter(evento => !evento.promoted))
  },

  porId (id) {
    return this.cargarEventos().then(eventos => eventos[id] || Promise.reject(new Error('Evento no encontrado')))
  }
}
