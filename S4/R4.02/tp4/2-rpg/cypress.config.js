export default {
  viewportWidth: 1920,
  viewportHeight: 1080,
  video: false,
  reporter: 'mochawesome',
  defaultCommandTimeout: 100,
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    }
  }
};
