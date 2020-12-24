import React from 'react';
import Loadable from 'react-loadable';

const loadingComponent = ({ error, pastDelay }) => {
    if (error) {
      return <div>Error!</div>;
    } else if (pastDelay) {
      // return <div>Loading...</div>;
      return <div />;
    } else {
      return null;
    }
};

export const homeRoute = 
{
    name: '/',
    path: '/',
    exact: true,
    component: Loadable({
      loader: () => import('@@/src/pages/HomePage'),
      loading: loadingComponent,
      delay: 300,
    }),
    auth: true
};

export const articleManageRoute = 
{
    name: 'articleManage',
    path: '/articleManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/ArticleManage'),
      loading: loadingComponent,
      delay: 300,
    }),
    auth: true
};

export const userManageRoute = 
{
    name: 'userManage',
    path: '/userManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/UserManage'),
      loading: loadingComponent,
      delay: 300,
    }),
    auth: true
};

export const markManageRoute = 
{
    name: 'markManage',
    path: '/markManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/MarkManage'),
      loading: loadingComponent,
      delay: 300,
    }),
    auth: true
};

export const seriesManageRoute = 
{
    name: 'seriesManage',
    path: '/seriesManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/SeriesManage'),
      loading: loadingComponent,
      delay: 300,
    }),
    auth: true
};

export const loginPageRoute = 
{
    name: 'login',
    path: '/login',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/LoginPage'),
      loading: loadingComponent,
      delay: 300,
    }),
};

export const routers = [
  homeRoute,
  articleManageRoute,
  userManageRoute,
  markManageRoute,
  seriesManageRoute,
  loginPageRoute
];
