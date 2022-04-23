module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}",],
  theme: {
    extend: {
      colors: {
        'EerieBlack': '#232526',
        'Onyx': '#414345'
      }
    },
    backgroundSize: {
      'hero': '880px'
    }
  },
  plugins: [require("daisyui")],
}
