from socketserver import ThreadingTCPServer

from random_server import RequestHandler

HOST = "127.0.0.1"
PORT = 5000

if __name__ == "__main__":
    with ThreadingTCPServer((HOST, PORT), RequestHandler) as server:
        try:
            print("%s:%s Running" % (HOST, PORT))
            server.serve_forever()
        except KeyboardInterrupt:
            print("Server Shutdown")
            server.shutdown()