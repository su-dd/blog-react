import BasicLayout from "@/layouts/BasicLayout";
// 局部热更新
import { hot } from 'react-hot-loader';
function App() {
  return (
    <div className="App">
      <BasicLayout />
    </div>
  );
}

export default hot(module)(App);
