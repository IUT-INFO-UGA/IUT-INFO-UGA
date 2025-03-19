import http from 'node:http';
import fs from 'node:fs';
import director from 'director';
import serveStatic from 'serve-static';
import finalhandler from 'finalhandler';

const port = 8090;

/**
 * Display the main page.
 */
let showMain = function () {
  fs.readFile('./index.html', (err, html) => {
    this.res.writeHeader(200, { 'Content-Type': 'text/html' });
    this.res.write(html);
    this.res.end();
  });
};

let verifyEmail = function (email) {
  this.res.writeHeader(200, { 'Content-Type': 'application/json' });
  this.res.write(
    JSON.stringify({
      trusted: true
    })
  );
  this.res.end();
};

// Create a static server
const serve = serveStatic('assets/');

// Specify the routes.
let routes = {
  '/': { get: showMain },
  '/verification': { get: verifyEmail }
};

// Create the router
let router = new director.http.Router(routes);

// Create the server
let server = http.createServer(function (req, res) {
  router.dispatch(req, res, function (err) {
    if (err) {
      serve(req, res, finalhandler(req,res));
    }
  });
});

// Listen on the specific port
console.log('Server ready to accept requests on port %d', port);
server.listen(port);