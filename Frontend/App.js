import React, {Component} from 'react';
// import 'react-native-gesture-handler';
import LoginComponent from './components/LoginComponent';
import { NavigationContainer } from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import SignUpComponent from './components/SignUpComponent';
import DashBoardComponent from './components/DashBoardComponent';

const Stack = createStackNavigator();

export default class App extends Component   {
  render() {
    return (
      <NavigationContainer>
      <Stack.Navigator screenOptions={{header: () => null}}>
        <Stack.Screen name="SignIn" component={LoginComponent} />
        <Stack.Screen name="SignUp" component={SignUpComponent} />
        <Stack.Screen name="Home" component={DashBoardComponent} />
      </Stack.Navigator>
    </NavigationContainer>
    )
  }
}