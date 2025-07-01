import subprocess
import os

# Function to run adb command and get the output
def adb_command(command):
    result = subprocess.run(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    return result.stdout

# Check if the device is connected
def get_device_list():
    command = ['adb', 'devices']
    devices = adb_command(command)
    if 'device' in devices:
        print("Device connected")
        return True
    else:
        print("No device connected")
        return False

# Find the Room database folder
def find_room_database():
    if not get_device_list():
        return
    
    # This command navigates to the data directory of the app on the Android device
    # Change this path to the actual package name of your app
    app_package_name = "com.example.todo_list"  # Replace with your app's package name
    db_path = f"/data/data/{app_package_name}/databases/"
    
    # Check if the database folder exists
    command = ['adb', 'shell', 'ls', db_path]
    output = adb_command(command)
    
    if "No such file" in output:
        print("Database folder not found.")
    else:
        print(f"Room database folder found at: {db_path}")
        print("Databases:")
        print(output)

# Run the function
find_room_database()
