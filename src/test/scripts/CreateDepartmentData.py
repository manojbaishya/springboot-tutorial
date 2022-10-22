import aiohttp
import asyncio
from faker import Faker

generator = Faker()
iterations = 10


async def main():
    async with aiohttp.ClientSession() as session:
        for _ in range(iterations):
            payload = {
                "departmentName": generator.company(),
                "departmentAddress": generator.address(),
                "departmentCode": generator.ssn(),
            }
            async with session.post(
                "http://localhost:5000/department", json=payload
            ) as response:
                print(f"Response status code {response.status}")
                print(await response.json())


asyncio.run(main())
