from socketserver import BaseRequestHandler

class RequestHandler(BaseRequestHandler):
    def handle(self):
        while True:
            byte_ = self.request.recv(4096)
            if not byte_:
                break

            msg = byte_.decode()
            print(msg)