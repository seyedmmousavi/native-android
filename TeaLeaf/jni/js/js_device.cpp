/* @license
 * This file is part of the Game Closure SDK.
 *
 * The Game Closure SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 
 * The Game Closure SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 
 * You should have received a copy of the GNU General Public License
 * along with the Game Closure SDK.  If not, see <http://www.gnu.org/licenses/>.
 */
#include "js/js_device.h"
#include "platform/device.h"

using namespace v8;

Handle<Value> js_device_global_id(Local<String> name, const AccessorInfo &info) {
	const char* str = device_global_id();
	Handle<String> result = String::New(str);
	free((void*)str);
	return result;
}

Handle<Value> js_device_info(Local<String> name, const AccessorInfo &info) {
	const char* str = device_info();
	Handle<String> result = String::New(str);
	free((void*)str);
	return result;
}

Handle<ObjectTemplate> js_device_get_template() {
	Handle<ObjectTemplate> device = ObjectTemplate::New();
	device->SetAccessor(String::New("globalID"), js_device_global_id);
	device->SetAccessor(String::New("native_info"), js_device_info);
	return device;
}
