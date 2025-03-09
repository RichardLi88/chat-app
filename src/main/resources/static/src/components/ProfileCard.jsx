import { Avatar, Flex, Text } from "@mantine/core";
function ProfileCard(data) {
  return (
    <>
      <Flex direction="column" bd="1px solid black.7">
        <Flex>
          <Avatar radius="xl" color="initials" name={data.name} />
        </Flex>
        <Flex>
          <Text size="xl">{data.username}</Text>
        </Flex>
      </Flex>
    </>
  );
}
