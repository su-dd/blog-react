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

export const homeRouterConfig = 
{
    name: '/',
    path: '/',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/Home'),
      loading: loadingComponent,
      delay: 300,
    }),
};

export const articleManageConfig = 
{
    name: 'articleManage',
    path: '/articleManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/ArticleManage'),
      loading: loadingComponent,
      delay: 300,
    }),
};

export const userManageConfig = 
{
    name: 'userManage',
    path: '/userManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/UserManage'),
      loading: loadingComponent,
      delay: 300,
    }),
};

export const markManageConfig = 
{
    name: 'markManage',
    path: '/markManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/MarkManage'),
      loading: loadingComponent,
      delay: 300,
    }),
};

export const seriesManageConfig = 
{
    name: 'seriesManage',
    path: '/seriesManage',
    exact: true,
    component: Loadable({
      loader: () => import('@/pages/SeriesManage'),
      loading: loadingComponent,
      delay: 300,
    }),
};