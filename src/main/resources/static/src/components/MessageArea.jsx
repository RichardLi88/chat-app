import { Flex, ScrollArea } from "@mantine/core";
import Message from "./Message";
const messages = [
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 234 },
];
function MessageArea() {
  return (
    <>
      <Flex direction="column" gap="10px" mah="90%">
        <ScrollArea px="10px">
          {messages.map((message, index) => {
            return <Message key={index} data={message} />;
          })}
        </ScrollArea>
      </Flex>
    </>
  );
}

export default MessageArea;
