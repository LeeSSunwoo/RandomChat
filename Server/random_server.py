from socketserver import BaseRequestHandler

class RequestHandler(BaseRequestHandler):
    def handle(self):
        while True:
            byte_ = self.request.recv(4096)
            msg = self.get_string_from_byte(byte_)
            print(msg)

    def get_string_from_byte(self, byte_data):
        return byte_data.decode() if byte_data else str()