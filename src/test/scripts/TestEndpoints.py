import aiohttp
import asyncio


async def main():
    async with aiohttp.ClientSession() as session:
        async with session.post(
            "http://localhost:5000/department",
            json={
                "departmentName": "dummy",
                "departmentAddress": "dummy",
                "departmentCode": "dummy",
            },
        ) as response:
            print(f"Response completed with status code {response.status}")
            print(await response.json())


asyncio.run(main())
