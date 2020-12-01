import React, {useEffect} from "react";
import
  {
    BrowserRouter as Router,
    Switch,
    Route,
    // Link
  } from "react-router-dom";

import routers from '@/router/router';

const App = () =>
{
  return (
    <div className="App">
      <Router>
        <Switch>
          {routers.map((r, key) => (
            <Route
              component={r.component}
              exact={!!r.exact}
              key={key}
              path={r.path}
            />
          ))}
        </Switch>
      </Router>
    </div>
  );
}

export default App;
