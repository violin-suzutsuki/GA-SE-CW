module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}",],
  theme: {
    extend: {
      colors: {
        'FooterOne': '#232526',
        'FooterTwo': '#414345'
      }
    },
  },
  plugins: [require("daisyui")],
}
