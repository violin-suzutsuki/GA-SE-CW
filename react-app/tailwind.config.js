module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}",],
  theme: {
    extend: {
      colors: {
        'EerieBlack': '#232526',
        'Onyx': '#414345'
      },
      fontSize: {
        '5.5xl': '2.75rem'
      }
    },
    backgroundSize: {
      'hero': '880px'
    }
  },
  plugins: [require("daisyui")],
}
