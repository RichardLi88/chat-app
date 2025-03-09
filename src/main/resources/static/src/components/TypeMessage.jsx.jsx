import { Button, Flex, TextInput } from "@mantine/core";

function TypeMessage() {
  return (
    <>
      <Flex w="100%">
        <TextInput placeholder="Type something" flex="1" />
        <Button variant="filled" w="100px">
          Send
        </Button>
      </Flex>
    </>
  );
}
export default TypeMessage;
